$(document).ready(function () {
  google.charts.load("current", { packages: ["corechart"] });
  google.charts.setOnLoadCallback(fetchAndDrawCharts);

  function fetchAndDrawCharts() {
    $.ajax({
      url: "http://localhost:8080/web-mp2/linhaservlet",
      method: "GET",
      dataType: "json",
      success: function (data) {
        drawCharts(data);
      },
      error: function (xhr, status, error) {
        console.error("Erro na requisição:", status, error);
      },
    });
  }

  function drawCharts(data) {
    var dataLotacaoArray = [["Ponto de Parada", "Lotação"]];
    $.each(data, function (index, ponto) {
      dataLotacaoArray.push([ponto.nome, ponto.lotacao]);
    });

    var dataGastoArray = [["Ponto de Parada", "Gasto por km"]];
    $.each(data, function (index, ponto) {
      dataGastoArray.push([ponto.nome, ponto.gastoPorKm]);
    });

    var chartLotacaoData =
      google.visualization.arrayToDataTable(dataLotacaoArray);
    var chartGastoData = google.visualization.arrayToDataTable(dataGastoArray);

    var optionsLotacao = {
      title: "Lotação dos Pontos de Parada",
      legend: "none",
      bars: "vertical",
      bar: { groupWidth: "80%" },
    };

    var optionsGastoPorKm = {
      title: "Gasto por km dos Pontos de Parada",
      legend: "none",
      bars: "vertical",
      bar: { groupWidth: "80%" },
    };

    var chartLotacao = new google.visualization.ColumnChart(
      $("#chartLotacao")[0]
    );
    var chartGastoPorKm = new google.visualization.ColumnChart(
      $("#chartGastoPorKm")[0]
    );

    chartLotacao.draw(chartLotacaoData, optionsLotacao);
    chartGastoPorKm.draw(chartGastoData, optionsGastoPorKm);
  }
});
