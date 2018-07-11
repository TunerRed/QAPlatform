package com.qasite.test;

import com.qasite.bean.User;
import com.qasite.dao.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

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
		for(int i = 0;i<10;i++) {
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
