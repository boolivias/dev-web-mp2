<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gráficos de Gasto por km e Lotação Média</title>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script src="getGraficos.js"></script>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 20px;
        }
        .charts-container {
            display: flex;
            justify-content: space-around;
            flex-wrap: wrap;
        }
        .chart {
            width: 400px;
            height: 300px;
            margin: 10px;
        }
    </style>
</head>
<body>
    <h1>Gráficos de Gasto por km e Lotação Média</h1>

    <div class="charts-container">
        <div id="chartLotacao" class="chart"></div>
        <div id="chartGastoPorKm" class="chart"></div>
    </div>
</body>
</html>
