<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/BootStrapStudy/css/bootstrap.css">
  <script type="text/javascript" src="<%= request.getContextPath() %>/js/jquery-2.0.0.js"></script>
  <script type="text/javascript" src="<%= request.getContextPath() %>/BootStrapStudy/js/bootstrap.js"></script>
</head>
<body>

<div class="container">
  <h1>h1 Bootstrap heading (36px)</h1>
  <h2>h2 Bootstrap heading (30px)</h2>
  <h3>h3 Bootstrap heading (24px)</h3>
  <h4>h4 Bootstrap heading (18px)</h4>
  <h5>h5 Bootstrap heading (14px)</h5>
  <h6>h6 Bootstrap heading (12px)</h6>
</div>

<div class="container" style="width: 50%; margin-top: 100px;">
  <h2>Contextual Backgrounds</h2>
  <p>Use the contextual background classes to provide "meaning through colors":</p>
  <p class="bg-primary">This text is important.</p>
  <p class="bg-success">This text indicates success.</p>
  <p class="bg-info">This text represents some information.</p>
  <p class="bg-warning">This text represents a warning.</p>
  <p class="bg-danger">This text represents danger.</p>
</div>

</html>