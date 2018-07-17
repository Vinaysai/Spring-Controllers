<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1><center>Student Details</center></h1><br><center><a href="liststudents.htm">Refresh</a><br></center>
<c:if test="${Result ne null }">

<h3 style="color:red"><center>${Result }</center></h3>
</c:if>

<table bgcolor="cyan" border="1" width=" 60%" align="center">
  <tr bgcolor="green"><th>Sno</th><th>Sname</th><th>SAdd</th><th>Action1</th><th>Action2</th></tr>
  <c:choose>
    <c:when test="${stList ne null }">
       <c:forEach var="st" items="${stList}">
         <tr>
          <td><c:out value="${st.sno }"/></td>
          <td><c:out value="${st.sname }"/></td>
          <td><c:out value="${st.sadd }"/></td>
          <td><a href="edit.htm?id=${st.sno }">EDIT</a>
          <td><a href="delete_result.htm?id=${st.sno }">DELETE</a>
       </c:forEach>
    
    </c:when>
    <c:otherwise>
    	<span style="color:red" >No Records Found</span>
    	
    </c:otherwise>
  </c:choose>
    
</table>
<br><br>
 <center><a href="insert_student.htm">Insert New Student</a></center> <br>
 <center><a href="home.htm">Home</a></center> <br>