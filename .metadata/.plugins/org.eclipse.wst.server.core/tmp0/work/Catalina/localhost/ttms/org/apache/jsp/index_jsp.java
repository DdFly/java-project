/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.21
 * Generated at: 2016-11-16 14:29:16 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import xupt.se.ttms.model.Employee;
import java.util.ArrayList;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/nav.jsp", Long.valueOf(1472888236000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("xupt.se.ttms.model.Employee");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
 
   String contextPath = request.getContextPath(); 
   request.setAttribute("contextPath", contextPath);

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"css/newadd.css\" rel=\"stylesheet\">\r\n");
      out.write("<title>员工信息</title>\r\n");
      out.write("<style>\r\n");
      out.write("body {width:100%}\r\n");
      out.write(".table th, .table td {  \r\n");
      out.write("text-align: center;\r\n");
      out.write("height:30px;\r\n");
      out.write("} \r\n");
      out.write("</style>\r\n");
      out.write("<script src=\"js/jquery-2.1.3.min.js\"></script>\r\n");
      out.write("<script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div style=\"height:50px;line-height:50px;font-size:25px;vertical-align: middle;text-align: center\" class=\"bg-primary\">XXX影院管理系统</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"row\" style=\"padding:10px 10px\">\r\n");
      out.write("\r\n");
      out.write("\t<!-- 左导航栏 -->\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"css/newadd.css\" rel=\"stylesheet\">\r\n");
      out.write("<title>员工信息</title>\r\n");
      out.write("<style>\r\n");
      out.write(".table th, .table td {  \r\n");
      out.write("text-align: center;\r\n");
      out.write("height:30px;\r\n");
      out.write("} \r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"col-md-2\">\r\n");
      out.write("\t\t<div class=\"panel panel-primary\">\r\n");
      out.write("\t\t\t  <div class=\"panel-heading\">\r\n");
      out.write("\t\t\t    <h3 class=\"panel-title\">导航</h3>\r\n");
      out.write("\t\t\t  </div>\r\n");
      out.write("\t\t\t  <div class=\"panel-body\">\r\n");
      out.write("\t\t\t\t<table class=\"table table-hover\">\r\n");
      out.write("\t\t\t\t\t<tr><td><img src=\"images/renyuan.png\" width=\"24px\">&nbsp;&nbsp;<a href=\"index.jsp\">员工管理</a></td></tr>\r\n");
      out.write("\t\t\t\t\t<tr><td><img src=\"images/renyuan.png\" width=\"24px\">&nbsp;&nbsp;<a href=\"index1.jsp\">员工分页</a></td></tr>\r\n");
      out.write("\t\t\t\t\t<tr><td><img src=\"images/yingting.png\" width=\"24px\">&nbsp;&nbsp;<a href=\"javascript:alert('你们自己做!')\">影厅管理</a></td></tr>\r\n");
      out.write("\t\t\t\t\t<tr><td><img src=\"images/zuowei.png\" width=\"24px\">&nbsp;&nbsp;<a href=\"javascript:alert('你们自己做!')\">座位管理</a></td></tr>\r\n");
      out.write("\t\t\t\t\t<tr><td><img src=\"images/yingpian.png\" width=\"24px\">&nbsp;&nbsp;<a href=\"javascript:alert('可以不用做!')\">影片管理</a></td></tr>\r\n");
      out.write("\t\t\t\t\t<tr><td><img src=\"images/dingpiao.png\" width=\"24px\">&nbsp;&nbsp;<a href=\"javascript:alert('可以不用做!')\">订票管理</a></td></tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t  </div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"col-md-10\" style=\"padding-top:10px\">\r\n");
      out.write("\t\r\n");
      out.write("\t\t<!-- 查询块 -->\r\n");
      out.write("\t\t<div class=\"search\" >\r\n");
      out.write("\t\t\t<form class=\"form-inline\" name=\"myForm\" action=\"EmployeeServlet?method=search\" method=\"post\">\r\n");
      out.write("\t\t\t\t<!-- <input type=\"hidden\" name=\"method\" value=\"search\"/> -->\r\n");
      out.write("\t\t\t\t<input type=\"text\" class=\"form-control\" name=\"emp_name\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${search_emp_name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"/>\r\n");
      out.write("\t\t\t\t<input type=\"submit\" class=\"btn btn-primary\" value=\"查   询\" />&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t<input type=\"button\" class=\"btn btn-danger\" value=\"增   加\" onclick=\"javascript:window.location='add.jsp'\"/>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!-- 员工信息显示-->\r\n");
      out.write("\t\t<div style=\"padding-top:10px;\">\r\n");
      out.write("\t\t\t<table class=\"table table-bordered table-hover\" style=\"text-align:center;\">\r\n");
      out.write("\t\t   \t\t<tr>\r\n");
      out.write("\t\t   \t\t\t<th>用户id</th>\r\n");
      out.write("\t\t   \t\t\t<th>编号</th>\r\n");
      out.write("\t\t   \t\t\t<th>姓名</th>\r\n");
      out.write("\t\t   \t\t\t<th>电话</th>\r\n");
      out.write("\t\t   \t\t\t<th>地址</th>\r\n");
      out.write("\t\t   \t\t\t<th>邮箱</th>\r\n");
      out.write("\t\t   \t\t\t<th colspan=2>操作</th>\r\n");
      out.write("\t\t   \t\t</tr>\r\n");
      out.write("\t\t   \t\t");

		   		ArrayList<Employee> list=(ArrayList<Employee>)request.getAttribute("list");
		   		if(list!=null && list.size()>0)
		   		{
			   		for(int i=0;i<list.size();i++)
			   		{
			   		    if(i%2==0)
			   		        out.println("<tr class='success'>");
			   		    else
			   		    	out.println("<tr class='active'>");
		   		
      out.write("\r\n");
      out.write("\t\t   \t\t\t<th>");
      out.print(list.get(i).getEmp_id());
      out.write("</th>\r\n");
      out.write("\t\t   \t\t\t<th>");
      out.print(list.get(i).getEmp_no());
      out.write("</th>\r\n");
      out.write("\t\t   \t\t\t<th>");
      out.print(list.get(i).getEmp_name());
      out.write("</th>\r\n");
      out.write("\t\t   \t\t\t<th>");
      out.print(list.get(i).getEmp_tel_num());
      out.write("</th>\r\n");
      out.write("\t\t   \t\t\t<th>");
      out.print(list.get(i).getEmp_addr());
      out.write("</th>\r\n");
      out.write("\t\t   \t\t\t<th>");
      out.print(list.get(i).getEmp_email());
      out.write("</th>\r\n");
      out.write("\t\t   \t\t\t<th><a href=\"EmployeeServlet?method=searchById&emp_id=");
      out.print(list.get(i).getEmp_id());
      out.write("\">修改</a></th>\r\n");
      out.write("\t\t   \t\t\t<th><a href=\"EmployeeServlet?method=delete&emp_id=");
      out.print(list.get(i).getEmp_id());
      out.write("&emp_name=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${search_emp_name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">删除</a></th>\r\n");
      out.write("\t\t   \t\t</tr>\r\n");
      out.write("\t\t   \t\t");

		   			}
		   		}
		   		
      out.write("\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!-- 分页 -->\r\n");
      out.write("\t\t<!-- \r\n");
      out.write("\t\t<div class=\"text-center\">\r\n");
      out.write("\t\t\t<nav>\r\n");
      out.write("\t\t\t  <ul class=\"pagination\">\r\n");
      out.write("\t\t\t    <li><a href=\"#\">首页</a></li>\r\n");
      out.write("\t\t\t    <li><a href=\"#\">上一页</a></li>\r\n");
      out.write("\t\t\t    <li><a href=\"#\">下一页</a></li>\r\n");
      out.write("\t\t\t    <li><a href=\"#\">末页</a></li>\r\n");
      out.write("\t\t\t  </ul>\r\n");
      out.write("\t\t\t</nav>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t-->\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
