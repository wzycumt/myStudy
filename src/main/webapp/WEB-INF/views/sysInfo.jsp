<%@ page language="java" contentType="text/html; charset=UTF-8"%>

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
            <td class="active col-sm-1.5">操作系统</td>
            <td>219.142.8.222</td>
          </tr>
          <tr>
            <td class="active">JAVA运行环境</td>
            <td>Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36</td>
          </tr>
          <tr>
            <td class="active">JAVA虚拟机</td>
            <td>Chrome</td>
          </tr>
          <tr>
            <td class="active">系统用户</td>
            <td>56.0</td>
          </tr>
          <tr>
            <td class="active">用户主目录</td>
            <td>zh-CN, zh;q=0.8</td>
          </tr>
          <tr>
            <td class="active">最大内存</td>
            <td></td>
          </tr>
          <tr>
            <td class="active">已用内存</td>
            <td>Windows 10</td>
          </tr>
          <tr>
            <td class="active">可用内存</td>
            <td>Windows 10</td>
          </tr>
        </tbody>
      </table>
    </div>
    <div role="tabpanel" class="tab-pane fade" id="client">
      <table class="table table-bordered">
        <tbody>
          <tr>
            <td class="active col-sm-1.5">本机IP</td>
            <td>219.142.8.222</td>
          </tr>
          <tr>
            <td class="active">操作系统</td>
            <td>Windows 10</td>
          </tr>
          <tr>
            <td class="active">用户代理</td>
            <td>Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36</td>
          </tr>
          <tr>
            <td class="active">浏览器类型</td>
            <td>Chrome</td>
          </tr>
          <tr>
            <td class="active">浏览器版本</td>
            <td>56.0</td>
          </tr>
          <tr>
            <td class="active">浏览器语言</td>
            <td>zh-CN, zh;q=0.8</td>
          </tr>
          <tr>
            <td class="active">分辨率</td>
            <td id="tdRatio"></td>
          </tr>
        </tbody>
      </table>
      <script>
      	$(function() {
      		$("#tdRatio").html(window.screen.width + " * " + window.screen.height);
      	})
      </script>
    </div>
  </div>
