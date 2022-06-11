<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>

<page:template>

    <jsp:attribute name="title">User</jsp:attribute>

    <jsp:body>
        <h1>Адрес</h1>

        <c:if test="${not empty user}">
            <c:url value="/update/${user.id}" var="updateUser" />
            <c:url value="/delete/${user.id}" var="deleteUser" />
            <div class="container flex-box">
                <a class="btn btn-warning" href="${updateUser}">Edit</a>
                <a class="btn btn-danger" href="${deleteUser}">Delete</a>
            </div>

            <div class="container">
                <h2>${user.name}</h2>
                <span style="color: gray;">Id: ${user.id}</span>
                <h5>Телефон: ${user.phone}</h5>
                <h5>E-Mail: ${user.email}</h5>
                <c:if test="${not empty user.blog}">
                    <h5>Блог:
                        ${user.blog}
                    </h5>
                </c:if>
                <h5>Примечание: ${user.note}</h5>
            </div>
        </c:if>
    </jsp:body>

</page:template>
