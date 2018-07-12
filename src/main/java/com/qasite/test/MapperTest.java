package com.qasite.test;

import com.qasite.bean.Answer;
import com.qasite.bean.Question;
import com.qasite.bean.User;
import com.qasite.dao.AnswerMapper;
import com.qasite.dao.QuestionMapper;
import com.qasite.dao.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.*;
import java.util.*;
import java.util.logging.Logger;

/**
 * 测试DAO层
 * @author copywang
 * 1. 导入springtest模块-pom.xml配置
 * 2. @ContextConfiguration指定spring配置文件的位置
 * 3. 直接autowired找对象
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class MapperTest {

	@Autowired
	SqlSession sqlSession;
	/**
	 * 测试DepartmentMapper.xml
	 */
	@Test
	public void testprepareData() {

        //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        //df.format(Math.random()*3<2?new Date():new Date());
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		for(int i = 0;i<90;i++) {
			String name = UUID.randomUUID().toString().substring(0, 5) + i;
            Date status = null,reg_time = getDateBefore(new Date(),10);
            if (Math.random()*5<2){
                status = getDateAfter(new Date(),10);
            }else {
                status = getDateBefore(new Date(),5);
            }
			mapper.insert(new User( name, name,name+"@163.com",reg_time,status));
		}

	}

	/*
	* 向数据库中插入问题，问题源为根目录下的questions.txt
	* 插入的规模和对应的用户可以指定
	* */
	@Test
	public void insertQuestionsAndReplies() throws Exception{
        //提问者的id，根据自己数据库的实际情况调整
        /*
        * count_of_question 要插入的问题的数量（会自动插入相应的回复）
        * count_of_reply 每个问题下最大的回复数量
        * user_id_min 在自己的数据库中，用户id的最小值（或是要匹配的问题提出者列表的id基值）
        * user_size 要将插入的问题匹配给多少个用户，建议远小于问题数量，保证每个用户有较多问题，方便测试
        * */
	    int count_of_question = 20,count_of_reply = 6,user_id_min=110,user_size = 10;

        String pathname = "questions.txt";
        File filename = new File(pathname);
        InputStreamReader reader = new InputStreamReader(
                new FileInputStream(filename));
        BufferedReader br = new BufferedReader(reader);

        List< LinkedList<String> > questions = new LinkedList<LinkedList<String> >();
        String line = "",question = "";
        line = br.readLine();
        while (line != null) {
            if (line != null && line.endsWith("？")) {
                question = line;
                questions.add(new LinkedList<String>());
                if (question.length() > 20)
                    question = question.substring(0,10);
                questions.get(questions.size()-1).add(question);
                line = br.readLine();
            }
            if (questions.size() > 0 && questions.get(questions.size()-1).size()<=count_of_reply+1){
                if (line.length() > 40){//句子过长则根据句号进行分割
                    String[] answers = line.split("。");
                    for (int k = 0; k < answers.length; k++){
                        questions.get(questions.size()-1).add(answers[k]);
                    }
                }else if(line.length()>15){//句子过短则跳过不插入
                    questions.get(questions.size()-1).add(line);
                }
            }
            line = br.readLine();
        }

        QuestionMapper questionMapper = sqlSession.getMapper(QuestionMapper.class);
        AnswerMapper answerMapper = sqlSession.getMapper(AnswerMapper.class);
        for(int i = 0;i<count_of_question && i<questions.size();i++) {
            Integer ariser_id = (int)(Math.random()*user_size)+user_id_min;
            questionMapper.insert(new Question(getDateBefore(new Date(),(int)(Math.random()*3)-1),
                    questions.get(i).get(0),
                    (questions.get(i).get(0)+questions.get(i).get(0)),
                     ariser_id,
                    (int)(Math.random()*10)+10, (int)(Math.random()*2),
                    questions.get(i).size()-1));
            Integer best = (int)(Math.random()*(questions.get(i).size()-1));
            for (int j = 0; j < questions.get(i).size()-1; j++){
                LinkedList<String> an = questions.get(i);
                answerMapper.insert(new Answer(an.get(j+1),(int)(Math.random()*user_size)+user_id_min,ariser_id,(int)Math.random()*2));
            }
        }
    }

    /**
     * 得到几天后的时间
     * @param d
     * @param day
     * @return
     */
    public static Date getDateAfter(Date d,int day){
        Calendar now =Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE,now.get(Calendar.DATE)+day);
        return now.getTime();
    }


    /**
     * 得到几天前的时间
     * @param d
     * @param day
     * @return
     */
    public static Date getDateBefore(Date d,int day){
        Calendar now =Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE,now.get(Calendar.DATE)-day);
        return now.getTime();
    }


}
