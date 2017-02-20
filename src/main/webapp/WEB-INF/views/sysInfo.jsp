<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 

  <!-- Nav tabs -->
  <ul class="nav nav-tabs" role="tablist">
    <li role="presentation" class="active"><a href="#server" aria-controls="server" role="tab" data-toggle="tab">服务器信息</a></li>
    <li role="presentation"><a href="#client" aria-controls="client" role="tab" data-toggle="tab">客户端信息</a></li>
  </ul>

  <!-- Tab panes -->
  <div class="tab-content">
    <div role="tabpanel" class="tab-pane fade in active" id="server">
      <table class="table table-bordered">
        <tbody>
          <tr>
            <td class="active col-md-2">操作系统</td>
            <td class="col-md-10">${props['os.name']}/${props['os.version']}</td>
          </tr>
          <tr>
            <td class="active">JAVA运行环境</td>
            <td>${props['java.runtime.name']}/${props['java.runtime.version']}</td>
          </tr>
          <tr>
            <td class="active">JAVA虚拟机</td>
            <td>${props['java.vm.name']}/${props['java.vm.version']}</td>
          </tr>
          <tr>
            <td class="active">系统用户</td>
            <td>${props['user.name']}</td>
          </tr>
          <tr>
            <td class="active">用户主目录</td>
            <td>${props['user.home']}</td>
          </tr>
          <tr>
            <td class="active">最大内存</td>
            <td><fmt:formatNumber value="${maxMemoryMB}" pattern="#.00"/> MB</td>
          </tr>
          <tr>
            <td class="active">已用内存</td>
            <td><fmt:formatNumber value="${usedMemoryMB}" pattern="#.00"/> MB</td>
          </tr>
          <tr>
            <td class="active">可用内存</td>
            <td><fmt:formatNumber value="${useableMemoryMB}" pattern="#.00"/> MB</td>
          </tr>
        </tbody>
      </table>
    </div>
    <div role="tabpanel" class="tab-pane fade" id="client">
      <table class="table table-bordered">
        <tbody>
          <tr>
            <td class="active col-md-2">操作系统</td>
            <td class="col-md-10"><span id="osName"></span></td>
          </tr>
          <tr>
            <td class="active">客户端IP</td>
            <td><span id="clientIp"></span></td>
          </tr>
          <tr>
            <td class="active">用户代理</td>
            <td><span id="userAgent"></span></td>
          </tr>
          <tr>
            <td class="active">浏览器类型</td>
            <td><span id="browerType"></span></td>
          </tr>
          <tr>
            <td class="active">浏览器版本</td>
            <td><span id="browerVersion"></span></td>
          </tr>
          <tr>
            <td class="active">浏览器语言</td>
            <td><span id="browerLanguage"></span></td>
          </tr>
          <tr>
            <td class="active">分辨率</td>
            <td id="resolution"></td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>

<script type="text/javascript" src="http://pv.sohu.com/cityjson" charset="gb2312"></script>
<script type="text/javascript">
	$(document).ready(function() {
	    $('#osName').text(getClientOSName());
	    $('#clientIp').text(returnCitySN["cip"]+' '+returnCitySN["cname"]);
	    $('#userAgent').text(navigator.userAgent); //用户代理
	    $('#browerType').text(getBrowerType().type); //浏览器类型
	    $('#browerVersion').text(getBrowerType().version); //浏览器版本
	    $('#browerLanguage').text(navigator.language); //浏览器语言
	    $('#resolution').text(window.screen.width + ' * ' + window.screen.height); //分辨率
	})
  	
	//获取客户端操作系统名称
	function getClientOSName() {
	    var sUA=navigator.userAgent.toLowerCase();
	    if(sUA.indexOf( 'win' ) >=0){
	        if(sUA.indexOf("nt 3.1")>=0) {return "Windows NT 3.1";}
	        if(sUA.indexOf("nt 3.5")>=0) {return "Windows NT 3.5";}
	        if(sUA.indexOf("nt 4.0")>=0) {return "Windows NT 4.0";}
	        if((sUA.indexOf('nt 5.0')>=0) || (sUA.indexOf('2000')>=0)) {return 'Windows 2000';}
	        if((sUA.indexOf("nt 5.1")>=0)||(sUA.indexOf("XP")>=0)) {return "Windows XP"; }
	        if(sUA.indexOf("nt 5.2")>=0) {return "Windows Server 2003";}
	        if(sUA.indexOf("nt 6.0")>=0) {return "Windows Vista";}
	        if(sUA.indexOf("nt 6.1")>=0) {return "Windows 7";}
	        if(sUA.indexOf("nt 6.2")>=0) {return "Windows 8";}
	        if(sUA.indexOf("nt 6.3")>=0) {return "Windows 8.1";}
	        if(sUA.indexOf("nt 10.0")>=0) {return "Windows 10";}
	        if((sUA.indexOf("winnt")>=0) || (sUA.indexOf("windows nt")>=0)) {return "Windows NT";}
	        if((sUA.indexOf("win98")>=0) || (sUA.indexOf("windows 98")>=0)) {return "Windows 98";}
	        return "Windows";
      	}
	    if(sUA.indexOf('linux')>=0) {return 'Linux';}
	    if(sUA.indexOf('freebsd')>=0) {return 'FreeBSD';}
	    if(sUA.indexOf('x11')>=0) {return 'Unix';}
	    if(sUA.indexOf('mac') != -1) {return "Mac"; }
	    if(sUA.indexOf("sunos")>=0) {return 'Sun OS';}
	    if((sUA.indexOf("os/2")>=0) || (navigator.appVersion.indexOf("OS/2")>=0) || (sUA.indexOf("ibm-webexplorer")>=0)) {return "OS 2"}
	    if(navigator.platform == 'PalmOS' ) {return 'Palm OS'; }
	    if((navigator.platform == 'WinCE' ) || ( navigator.platform == 'Windows CE' ) || ( navigator.platform == 'Pocket PC' ) ) {return 'Windows CE';}
	    if(sUA.indexOf('webtv')>=0) {return 'WebTV Platform'; }
	    if(sUA.indexOf('netgem')>=0) {return 'Netgem';}
	    if(sUA.indexOf('opentv')>=0) {return 'OpenTV Platform';}
	    if(sUA.indexOf('symbian')>=0) {return 'Symbian';}
	    return "Unknown";
	}
	
	//获取浏览器类型
	function getBrowerType() {
	    var userAgent = navigator.userAgent.toLowerCase();
		if (userAgent.indexOf("trident/7.0") >= 0) {
		    var ver=userAgent.match(/rv:([\d.]+)/)[1];;
		    return {type:"Internet Explorer",version:ver};
	    } else if (userAgent.indexOf("msie") >= 0) {
		    var ver=userAgent.match(/msie ([\d.]+)/)[1];
		    return {type:"Internet Explorer",version:ver};
		} else if (userAgent.indexOf("edge") > 0) {
		    var ver=userAgent.match(/edge\/([\d.]+)/)[1];
		    return {type:"Edge",version:ver};
	    } else if (userAgent.indexOf("firefox") >= 0) {
		    var ver=userAgent.match(/firefox\/([\d.]+)/)[1];
		    return {type:"Firefox",version:ver};
		} else if(userAgent.indexOf("chrome") >= 0){
		    var ver=userAgent.match(/chrome\/([\d.]+)/)[1];
		    return {type:"Chrome",version:ver};
		} else if(userAgent.indexOf("opera") >= 0){
			var ver=userAgent.match(/opera.([\d.]+)/)[1];
			return {type:"Opera",version:ver};
		} else if(userAgent.indexOf("Safari") >= 0){
			var ver=userAgent.match(/version\/([\d.]+)/)[1];
			return {type:"Safari",version:ver};
		}
		var explorer = window.navigator.userAgent.toLowerCase() ;
		 //ie 
		 if (userAgent.indexOf("msie") >= 0) {
		    var ver=explorer.match(/msie ([\d.]+)/)[1];
		    return {type:"IE",version:ver};
		 }
		 //firefox 
		 else if (explorer.indexOf("firefox") >= 0) {
		    var ver=explorer.match(/firefox\/([\d.]+)/)[1];
		    return {type:"Firefox",version:ver};
		 }
		 //Chrome
		 else if(explorer.indexOf("chrome") >= 0){
		    var ver=explorer.match(/chrome\/([\d.]+)/)[1];
		     return {type:"Chrome",version:ver};
		 }
		 //Opera
		 else if(explorer.indexOf("opera") >= 0){
		 var ver=explorer.match(/opera.([\d.]+)/)[1];
		 return {type:"Opera",version:ver};
		 }
		 //Safari
		 else if(explorer.indexOf("Safari") >= 0){
		 var ver=explorer.match(/version\/([\d.]+)/)[1];
		 return {type:"Safari",version:ver};
		 }
	}

</script>