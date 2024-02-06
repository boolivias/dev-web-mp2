$(document).ready(function () {
  function showBusSchedule(busData) {
    var busList = $("#bus-list");
    busList.empty(); // Limpa a lista antes de atualizar

    $.each(busData, function (index, bus) {
      var listItem = $("<li>").text(
        `${bus.linha.id} - ${bus.linha.nome} - Chegada em ${bus.min_previsao} minutos.`
      );
      busList.append(listItem);
    });
  }

  function updateSchedule() {
    $.ajax({
      url: "http://localhost:8080/web-mp2/pontoservlet",
      method: "GET",
      data: { pontoId: 1 },
      dataType: "json",
      success: function (data) {
        showBusSchedule(data);
      },
      error: function (xhr, status, error) {
        console.error("Erro na requisição:", status, error);
      },
    });
  }

  $("#update-button").on("click", updateSchedule);

  updateSchedule();
});
