<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Horários de Chegada dos Ônibus</title>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script src="atualizaAgenda.js"></script>
    <style>
      body {
        font-family: "Arial", sans-serif;
        margin: 20px;
      }
      #bus-schedule {
        width: 400px;
        margin: 0 auto;
      }
      #update-button {
        margin-top: 10px;
        cursor: pointer;
      }
    </style>
  </head>
  <body>
    <h1>Horários de Chegada dos Ônibus</h1>

    <div id="bus-schedule">
      <h2>Lista de Ônibus</h2>
      <ul id="bus-list"></ul>
      <button id="update-button">Atualizar Lista</button>
    </div>
  </body>
</html>
