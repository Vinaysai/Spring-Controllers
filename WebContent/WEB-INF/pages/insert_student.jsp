<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<h1 style="color:green"><center>Student Registration</center></h1>

<form:form method="POST" commandName="stCmd">
Sno:<form:input path="sno"/><font color="red"><form:errors path="sno"/></font><br>
SName:<form:input path="sname"/><font color="red"><form:errors path="sname"/></font><br>
SAdd:<form:input path="sadd"/><font color="red"><form:errors path="sadd"/></font><br>
<input type="submit" value="Register"/>

</form:form>
