<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>

<page:template>

    <jsp:attribute name="title">Homepage</jsp:attribute>

    <jsp:body>
        <h1>Адресная книга</h1>

        <c:url value="/create" var="createUser" />
        <a class="btn btn-success" href="${createUser}">Create</a>

        <c:if test="${not empty users}">
            <table class="table table-striped">
                <thead class="table-header">
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Phone</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${users}" var="user">
                        <c:url value="/user/${user.id}" var="getUser" />
<%--                        <a href="${getUsers}">Get Users</a>--%>
                        <tr>
                            <td>${user.id}</td>
                            <td>
                                <a href="${getUser}">${user.name}</a>
                            </td>
                            <td>${user.phone}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </jsp:body>

</page:template>
