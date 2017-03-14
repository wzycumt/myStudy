<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- 递归显示树形菜单 --%>
<c:forEach var="menu" items="${menuTree}">
  <c:choose>
    <c:when test="${not empty menu.children}">
      <li>
        <a class="has-arrow" href="#"><i class="${menu.icon}"></i><span class="nav-label">${menu.name}</span></a>
        <ul aria-expanded="true">
          <c:set var="menuTree" value="${menu.children}" scope="request" />
          <jsp:include page="menuTree.jsp" />
        </ul>
      </li>
    </c:when>
    <c:otherwise>
      <li><a class="J_menuItem" href="${menu.url}"><i class="${menu.icon}"></i><span class="nav-label">${menu.name}</span></a></li>
    </c:otherwise>
  </c:choose>
</c:forEach>
