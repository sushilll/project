<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet">
<title>Homepage</title>
</head>
<body>
<%-- <s:form name="test" theme="simple">
or you can set theme for entire page as below static value

<s:set name="theme" value="'simple'" scope="page" /> 
or app level, add this to struts.xml
<constant name="struts.ui.theme" value="simple" />
--%>

	<s:div>
		<s:actionmessage/>
		<s:actionerror />
		<s:form action="/login" method="post">
			<label>Enter UserId</label>
			<s:textfield label="Enter User Id" name="userid" requiredLabel="true"></s:textfield>
			<label>Enter Password</label>
			<s:password label="Enter Password" name="pwd" requiredLabel="true"></s:password>
			<br>
			<s:checkbox name="remember" >Remeber Me</s:checkbox>
			<s:submit label="login"></s:submit>
		</s:form>
	</s:div>

</body>
</html>