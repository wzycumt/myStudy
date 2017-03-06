
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="renderer" content="webkit">
<%
String path = request.getContextPath(); //  path = "/travel"
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; // basePath="http://localhost:8080/travel/"
%>
<base href="<%=basePath%>">
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- <link rel="stylesheet" href="resources/css/dashboard.css"> -->

<script src="http://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- datatables插件 -->
<!-- <link rel="stylesheet" href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css"> -->
<link rel="stylesheet" href="http://cdn.datatables.net/plug-ins/28e7751dbec/integration/bootstrap/3/dataTables.bootstrap.css">
<script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
<script src="http://cdn.datatables.net/plug-ins/28e7751dbec/integration/bootstrap/3/dataTables.bootstrap.js"></script>

<!-- H+ UI -->
<link rel="shortcut icon" href="../img/favicon.ico">
<!-- <link href="resources/hplus-v4.1.0/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet"> -->
<link href="resources/hplus-v4.1.0/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
<link href="resources/hplus-v4.1.0/css/animate.min.css" rel="stylesheet">
<link href="resources/hplus-v4.1.0/css/style.min862f.css?v=4.1.0" rel="stylesheet">
<!-- <script src="resources/hplus-v4.1.0/js/jquery.min.js?v=2.1.4"></script> -->
<!-- <script src="resources/hplus-v4.1.0/js/bootstrap.min.js?v=3.3.6"></script> -->
<script src="resources/hplus-v4.1.0/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="resources/hplus-v4.1.0/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="resources/hplus-v4.1.0/js/plugins/layer/layer.min.js"></script>
<script src="resources/hplus-v4.1.0/js/hplus.min.js?v=4.1.0"></script>
<script type="text/javascript" src="resources/hplus-v4.1.0/js/contabs.min.js"></script>
<script src="resources/hplus-v4.1.0/js/plugins/pace/pace.min.js"></script>
    