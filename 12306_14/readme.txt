12306-09
�˰汾�����bootstrap����������
12306-10
��Ӷ�����ͨ��¼����֤��

12306-11
�˰汾�����jstl  el ���ʽͨ���˺��������˷�ҳ����
ʹ��ͨ��Ʊ����admin��Ʊ��ɾƱ�ܹ���ҳչʾ

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
�ı�bean.xml ʹ��mysql���ݿ�	

12306-13
(1)ͨ��<%@include file="user_statue_check.jsp"%>����ͨ�û���¼״̬��Ȩ�޽��п��ơ�
��2��ͨ������Filter��admin�ĵ�¼״̬��Ȩ�޽��п��ƣ�������WEB.XML�н�������<url-pattern>/Ҫ���˵�����ҳ��</url-pattern>
��3���޸���̨����22:04:09,980  WARN org.apache.struts2.components.ServletUrlRenderer:56 - No configuration found for the specified action: 'AdminLogin' in namespace: ''. Form action defaulting to 'action' attribute's literal value.
        �ľ��棬ͨ����<s:form>�����namespace��action��ͬ���� <s:form action="AdminLogin"  namespace="/">
 ��4����admin����Ӷ��û��Ŀ��Ʋ鿴���������loadUser  ��listUser
 
 12306-14
 �޸�loadUser��idԽ��,ͨ���ж�Խ����ѯֵ��size�жϣ���Խ�緵��null;
 
	