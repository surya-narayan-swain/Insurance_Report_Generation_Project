<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Insurance Report Application</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

<div class="container mt-5">
    <h3 class="pb-3 pt-3 text-center">Insurance Report Application</h3>

    <!-- Search Form -->
    <div class="card">
        <div class="card-header">
            <h4>Search Filters</h4>
        </div>
        <div class="card-body">
            <form:form action="search" modelAttribute="search" method="POST">
                <div class="row mb-3">
                    <div class="col-md-3">
                        <label for="planName" class="form-label">Plan Name</label>
                        <form:select path="planName" class="form-select">
                            <form:option value="">--Select--</form:option>
                            <form:options items="${names}" />
                        </form:select>
                    </div>

                    <div class="col-md-3">
                        <label for="planStatus" class="form-label">Plan Status</label>
                        <form:select path="planStatus" class="form-select">
                            <form:option value="">--Select--</form:option>
                            <form:options items="${status}" />
                        </form:select>
                    </div>

                    <div class="col-md-3">
                        <label for="gender" class="form-label">Gender</label>
                        <form:select path="gender" class="form-select">
                            <form:option value="">--Select--</form:option>
                            <form:option value="Male">Male</form:option>
                            <form:option value="Female">Female</form:option>
                        </form:select>
                    </div>

                    <div class="col-md-3">
                        <label for="startDate" class="form-label">Start Date</label>
                        <form:input type="date" path="startDate" class="form-control" />
                    </div>
                </div>

                <div class="row mb-3">
                    <div class="col-md-3">
                        <label for="endDate" class="form-label">End Date</label>
                        <form:input type="date" path="endDate" class="form-control" />
                    </div>
                </div>

                <div class="d-flex justify-content-between">
                    <a href="./" class="btn btn-secondary">Reset</a>
                    <input type="submit" value="Search" class="btn btn-primary">
                </div>
            </form:form>
        </div>
    </div>

    <!-- Table of Results -->
    <hr />
    <div class="card mt-4">
        <div class="card-header">
            <h4>Search Results</h4>
        </div>
        <div class="card-body">
            <table class="table table-striped table-bordered">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Holder Name</th>
                        <th>Plan Name</th>
                        <th>Plan Status</th>
                        <th>Gender</th>
                        <th>Start Date</th>
                        <th>End Date</th>
                        <th>Benefit Amount</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${plans}" var="plan" varStatus="index">
                        <tr>
                            <td>${index.count}</td>
                            <td>${plan.citizenName}</td>
                            <td>${plan.planName}</td>
                            <td>${plan.planStatus}</td>
                            <td>${plan.gender}</td>
                            <td>${plan.startDate}</td>
                            <td>${plan.endDate}</td>
                            <td>${plan.benefitAmount}</td>
                        </tr>
                    </c:forEach>
                    <c:if test="${empty plans}">
                        <tr>
                            <td colspan="8" class="text-center">No Records Found</td>
                        </tr>
                    </c:if>
                </tbody>
            </table>
        </div>
    </div>

    <!-- Export Section -->
    <hr />
    <div class="mt-3 text-center">
        <span>Export: </span>
        <a href="/Insurance_Report_Generation/excel" class="btn btn-success btn-sm">Export to Excel</a>&nbsp;&nbsp;&nbsp;
        <a href="/Insurance_Report_Generation/pdf" class="btn btn-danger btn-sm">Export to PDF</a>
    </div>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</body>
</html>
