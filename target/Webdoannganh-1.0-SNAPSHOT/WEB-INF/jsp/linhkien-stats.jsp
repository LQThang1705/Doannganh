<%-- 
    Document   : linhkien-stats
    Created on : Oct 14, 2022, 2:10:54 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="bg-info text-white text-center">Thống kê doanh thu theo linh kiện</h1>
<form action="">
    <div class="form-group">
        <label>Tu khóa</label>
        <input type="text" name="kw" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Từ thời điểm</label>
        <input type="date" name="fromDate" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Đến thời điểm</label>
        <input type="date" name="toDate" class="form-control"/>
    </div>
    <input type="submit" value="Bao cao" class="btn btn-success"/>
</form>

<div>
    <canvas id="myLinhkienStartsChart"></canvas>
</div>

<table class="table">
    <tr>
        <th>Mã sản phẩm</th>
        <th>Tên sản phẩm</th>
        <th>Doanh thu</th>
    </tr>
    <c:forEach items="${linhkienStats}" var="lk">
        <tr>
            <td>${lk[0]}</td>
            <td>${lk[1]}</td>
            <td>${lk[2]} VND</td>
        </tr>
    </c:forEach>
</table>
<script>
    let lklabels =[], lkinfo=[]
    
    <c:forEach items="${linhkienStats}" var="lk">
        lklabels.push('${lk[1]}')
        lkinfo.push(${lk[2]})
    </c:forEach>
    
    window.onload = function (){
        linhkienChart("myLinhkienStartsChart",lklabels, lkinfo)
    }
</script>


