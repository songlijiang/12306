12306-09
此版本添加了bootstrap日期输入插件
12306-10
添加对于普通登录的验证码

12306-11
此版本添加了jstl  el 表达式通过此函数增加了分页功能
使普通买票，和admin查票和删票能够分页展示

public List<Ticket> listForPage(int pageNow,int pageSize) {
//		String query = " top "+pageSize+" * from Ticket t where t.id not in(select top "+pageSize*(pageNow-1)+" id from Ticket )and num>0 ";
//		System.out.println(query);
//		List<Ticket> tickets = (List<Ticket>)hibernateTemplate.find(query);
//		return tickets;
		String query = "from Ticket t where t.num > 0";
		Query q = sessionFactory.getCurrentSession().createQuery(query);
		q.setFirstResult(pageSize*(pageNow-1));
		q.setMaxResults(pageSize);
		List<Ticket> tickets = (List<Ticket>)q.list();
	    return tickets;

		
	}
	
	
12306-12
改变bean.xml 使用mysql数据库	

12306-13
(1)通过<%@include file="user_statue_check.jsp"%>对普通用户登录状态及权限进行控制。
（2）通过改善Filter对admin的登录状态及权限进行控制，并且在WEB.XML中进行配置<url-pattern>/要过滤的敏感页面</url-pattern>
（3）修复后台弹出22:04:09,980  WARN org.apache.struts2.components.ServletUrlRenderer:56 - No configuration found for the specified action: 'AdminLogin' in namespace: ''. Form action defaulting to 'action' attribute's literal value.
        的警告，通过在<s:form>中添加namespace与action中同名即 <s:form action="AdminLogin"  namespace="/">
 （4）将admin中添加对用户的控制查看，即添加了loadUser  与listUser
 
 12306-14
 修复loadUser中id越界,通过判断越界后查询值得size判断，若越界返回null;
 
	