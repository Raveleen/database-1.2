<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Apartments</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="style.css" rel="stylesheet">
</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Apartments</a>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li><a href="/apartments">All apartments</a></li>
                <li><a href="#input_price" data-toggle="collapse">Apartments within price range</a>
                    <div id="input_price" class="collapse">
                        <form action="/apartments" method="get">
                            <div class="input-group-sm">
                                <input type="text" class="form-control" name="min_price" placeholder="Minimal price"><br>
                                <input type="text" class="form-control" name="max_price" placeholder="Maximal price"><br>
                                <button type="submit" class="btn btn-sm btn-success">Search</button>
                            </div>
                        </form>
                    </div>
                </li>
                <li><a href="#input_rooms" data-toggle="collapse">Apartments with certain number of rooms</a>
                    <div id="input_rooms" class="collapse">
                        <form action="/apartments" method="get">
                            <div class="input-group-sm">
                                <input type="text" class="form-control" name="rooms" placeholder="Number of rooms"><br>
                                <button type="submit" class="btn btn-sm btn-success">Search</button>
                            </div>
                        </form>
                    </div>
                </li>
                <li><a href="#input_district" data-toggle="collapse">Apartments in certain district</a>
                    <div id="input_district" class="collapse">
                        <form action="/apartments" method="get">
                            <div class="input-group-sm">
                                <input type="text" class="form-control" name="district" placeholder="District"><br>
                                <button type="submit" class="btn btn-sm btn-success">Search</button>
                            </div>
                        </form>
                    </div>
                </li>
                <li><a href="#input_area" data-toggle="collapse">Apartments within area range</a>
                    <div id="input_area" class="collapse">
                        <form action="/apartments" method="get">
                            <div class="input-group-sm">
                                <input type="text" class="form-control" name="min_area" placeholder="Minimal area"><br>
                                <input type="text" class="form-control" name="max_area" placeholder="Maximal area"><br>
                                <button type="submit" class="btn btn-sm btn-success">Search</button>
                            </div>
                        </form>
                    </div>
                </li>
                <li><a href="/add-form.jsp">Add apartment to base</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Rooms</th>
                        <th>Area</th>
                        <th>District</th>
                        <th>Address</th>
                        <th>Price</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list}" var="o">
                        <tr>
                            <td>${o.id}</td>
                            <td>${o.rooms}</td>
                            <td>${o.area}</td>
                            <td><c:out value="${o.district}"/></td>
                            <td><c:out value="${o.address}"/></td>
                            <td><c:out value="${o.price}"/></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>