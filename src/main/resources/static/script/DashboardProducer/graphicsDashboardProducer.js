

const certificationsAchieveds = document.getElementById('graphicCertificationsAchieveds');

new Chart(certificationsAchieveds, {
type: 'bar',

data: {
  labels: ['Não Possui', 'Sim/POA', 'SUSAF', 'SISBI', 'SELO ARTE', 'SIF'], //avaliar com professor a barra não possui
  datasets: [{
      maxBarThickness: 100,
      label: ' ', // remover aparência da label
      data: [55, 77, 30, 25, 25, 3],
      backgroundColor: ['rgba(75, 192, 192, 0.6)'],
      borderColor: ['rgba(75, 192, 192, 10)'],
      borderWidth: 4
  }]
},

options: {

  scales: {

    y: {
        ticks: {
            font: {
                family: 'Poppins', // Alterar aqui a família da fonte
                size: 16 // Alterar aqui o tamanho da fonte
            }
        },
        grid: {
            display: true, // ativa as linhas de grade do eixo Y
            lineWidth: 1
        },
        beginAtZero: true
    },

    x: {
        ticks: {
            font: {
                family: 'Poppins', // Alterar aqui a família da fonte
                size: 16 // Alterar aqui o tamanho da fonte
            }
        },
        grid: {
            display: true, // ativa as linhas de grade do eixo X
            lineWidth: 1
        }
    }
},

beginAtZero: true

}
});

const scriptElement = document.querySelector('script[src="../../script/DashboardProducer/graphicsDashboardProducer.js"]');
const myObjectData = JSON.parse(scriptElement.getAttribute('data-myobject'));

const labels = Object.keys(myObjectData).map(techId => myObjectData[techId].technologyName);
const produzindoData = Object.keys(myObjectData).map(techId => myObjectData[techId].count); // Aqui estamos acessando o valor 'count'
const complementacaoData = Object.keys(myObjectData).map(techId => myObjectData[techId].count);
const desistentesData = Object.keys(myObjectData).map(techId => myObjectData[techId].count); // Aqui também estamos acessando o valor 'count'


// Configurar o gráfico com os dados extraídos
new Chart(technologies, {
    type: 'bar',
    data: {
        labels: labels,
        datasets: [{
            label: 'Produzindo',
            backgroundColor: 'rgb(5, 155, 255, 0.6)',
            borderColor: 'rgb(5, 155, 255, 10)',
            borderWidth: 4,
            data: produzindoData
        }, {
            label: 'Em complementação',
            backgroundColor: 'rgb(255, 194, 52, 0.6)',
            borderColor: 'rgb(255, 194, 52)',
            borderWidth: 4,
            data: complementacaoData
        }, {
            label: 'Desistentes',
            backgroundColor: 'rgb(255, 64, 105, 0.6)',
            borderColor: 'rgb(255, 64, 105, 10)',
            borderWidth: 4,
            data: desistentesData
        }]
    },
    options: {
        scales: {
            y: {
                ticks: {
                    font: {
                        family: 'Poppins',
                        size: 16
                    }
                },
                grid: {
                    display: true,
                    lineWidth: 1
                },
                beginAtZero: true
            },
            x: {
                ticks: {
                    font: {
                        family: 'Poppins',
                        size: 16
                    }
                },
                grid: {
                    display: true,
                    lineWidth: 1
                }
            }
        },
        beginAtZero: true
    }
});
