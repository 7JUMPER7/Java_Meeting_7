<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>

<page:template>

    <jsp:attribute name="title">Edit</jsp:attribute>

    <jsp:body>
        <h1>Редактирование адреса</h1>

        <div class="container">
            <c:if test="${not empty user}">
                <form method="post" action="/update/${user.id}">
                    <label>ФИО:
                        <input type="text" name="name" value="${user.name}" required>
                    </label>
                    <label>Телефон:
                        <input type="tel" name="phone" value="${user.phone}" required>
                    </label>
                    <label>E-Mail:
                        <input type="email" name="email" value="${user.email}" required>
                    </label>
                    <label>Blog:
                        <input type="text" name="blog" value="${user.blog}">
                    </label>
                    <label>Note:
                        <input type="text" name="note" value="${user.note}">
                    </label>
                    <input type="submit" value="Update" class="btn btn-success">
                </form>
            </c:if>
        </div>
    </jsp:body>

</page:template>
