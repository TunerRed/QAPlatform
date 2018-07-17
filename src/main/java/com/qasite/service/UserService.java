package com.qasite.service;

import com.qasite.bean.Answer;
import com.qasite.bean.AnswerExample;
import com.qasite.bean.Question;
import com.qasite.bean.User;
import com.qasite.dao.AnswerMapper;
import com.qasite.dao.QuestionMapper;
import com.qasite.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private AnswerMapper answerMapper;

    public User login(String email, String password) {
        User user = userMapper.selectByEmail(email);
        if (user == null)
            return null;
        if (user.getPassword() == null || !password.equals(user.getPassword()))
            return null;
        return user;
    }

    public boolean register(User user) {
        User user1=userMapper.selectByEmail(user.getEmail());
        //User user2=UserMapper.selectByUsername(user.getUserName());
        if(user1==null/*&&user2==null*/) {
            userMapper.insert(user);
            return true;
        }
        return false;
    }

    public User getUserInfo(Integer id){
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    public void updateUserInfo(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    public boolean checkUserInfo(User user) {
        User emailUser = userMapper.selectByEmail(user.getEmail());
        if (emailUser == null)
            return true;
        if (emailUser.getId()==user.getId())
            return true;
        return false;
    }

    /*
    * 提交问题回复所要进行的一系列操作
    * 操作成功返回true
    * 若存在空的数据实体则返回操作失败false
    * */
    public Integer updateUserReply(Integer questionId, Integer replierId, Answer answer){
        //根据问题id找到问题实体
        Question question = questionMapper.selectByPrimaryKey(questionId);
        if (question == null)
            return -1;
        //根据回复者id找到用户实体
        User replier = getUserInfo(replierId);
        if (replier == null)
            return -1;
        //回答用户的积分增加User.DEFAULT_POINT点
        replier.setCredit(replier.getCredit()+User.DEFAULT_CREDIT_POINT);
        updateUserInfo(replier);
        //更新问题的回复数
        question.setAnswers(question.getAnswers()+1);
        questionMapper.updateByPrimaryKeySelective(question);
        //在Answer表里插入新的Answer数据
        answerMapper.insert(answer);
        /*
        * 获得刚才插入的answer在数据库中的id，即该用户发布回复中的（减少返回数据）最大回复id值
        * mybatisGenerator生成的xxxExample真是太强大了
        * */
        AnswerExample answerExample = new AnswerExample();
        answerExample.createCriteria().andReplierIdEqualTo(answer.getReplierId());
        answerExample.setOrderByClause("id desc");
        List<Answer> answers = answerMapper.selectByExample(answerExample);
        if (answers == null || answers.size() == 0)
            return -1;
        return answers.get(0).getId();
    }

    public User update_credit(int id,int point){
        User user = userMapper.selectByPrimaryKey(id);
        user.setCredit(user.getCredit() + point);
        userMapper.updateByPrimaryKey(user);
        return null;
    }

    public boolean setBest(Integer replyId){
        //找到回复实体
        Answer answer = answerMapper.selectByPrimaryKey(replyId);
        if (answer == null)
            return false;
        //找到回复者用户实体
        User replier = getUserInfo(answer.getReplierId());
        if (replier == null)
            return false;
        //找到问题实体
        Question question = questionMapper.selectByPrimaryKey(answer.getQuestionId());
        if (question == null)
            return false;
        //问题设为已关闭
        question.setStates(Question.STATUS_VALUE_CLOSED);
        questionMapper.updateByPrimaryKeySelective(question);
        //回复设为最佳答案
        answer.setState(Answer.BEST_VALUE_TRUE);
        answerMapper.updateByPrimaryKeySelective(answer);
        //回复者积分增加
        replier.setCredit(replier.getCredit()+question.getPoints());
        userMapper.updateByPrimaryKeySelective(replier);
        return true;
    }

    //检查禁言，并返回禁言天数
    public int checkRight(Integer Id){
        User a = userMapper.selectByPrimaryKey(Id);
        if (a.getStates()==null)
            return 0;
        Date now = new Date();
        long m = a.getStates().getTime()-now.getTime();
        double daysBetween=(double) (m+1000000)/(double) (3600*24*1000);
        int days = Integer.parseInt(new java.text.DecimalFormat("0").format(daysBetween));
        return days;
    }

    //确认发布问题
    public void askQuestion(Question qu){
        questionMapper.insert(qu);
    }

}
