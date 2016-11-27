<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Checkbox</title>
	<style>
  input[type=checkbox] {
    display:none;
  }
  input[type=checkbox] + label
   {
       background: #999;
       height: 16px;
       width: 16px;
       display:inline-block;
       padding: 0 0 0 0px;
       cursor:pointer;
   }
   
   input[type=checkbox]:checked + label
    {
        background: #0080FF;
        height: 16px;
        width: 16px;
        display:inline-block;
        padding: 0 0 0 0px;
        background-image: url('<%=request.getContextPath() %>/resources/images/disk.gif');
        cursor:pointer;
    }
	</style>
</head>

<body>

<p>
   <input type='checkbox' name='thing' value='valuable' id="thing"/><label for="thing"></label>

</body>
</html>