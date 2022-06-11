<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="page" tagdir="/WEB-INF/tags" %>

<page:template>

    <jsp:attribute name="title">Create</jsp:attribute>

    <jsp:body>
        <h1>Добавление адреса</h1>

        <div class="container">
            <form method="post" action="/create">
                <label>ФИО:
                    <input type="text" name="name" required>
                </label>
                <label>Телефон:
                    <input type="tel" name="phone" required>
                </label>
                <label>E-Mail:
                    <input type="email" name="email" required>
                </label>
                <label>Blog:
                    <input type="text" name="blog">
                </label>
                <label>Note:
                    <input type="text" name="note">
                </label>
                <input type="submit" value="Create" class="btn btn-success">
            </form>
        </div>
    </jsp:body>

</page:template>
