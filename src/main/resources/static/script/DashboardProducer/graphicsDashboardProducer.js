const ProductionStatus = document.getElementById('graphicProductionStatus');

const config1 = {

  type: 'doughnut',

  data: {

    labels: ['Ativos Produzindo', 'Ativos em complementação', 'Desistentes', 'Desligados'],

    datasets: [{

      label: '',

      data: [counts], //n funciona tirar duvida com o gui 

      backgroundColor: [

        '#059bff',
        '#ffc234',
        '#ff4069',
        '#9a9b98'

      ],

      hoverOffset: 4
      
    }]
  },

  options: {
    plugins: {
        legend: {
            labels: {

              font: {
                family: 'Poppins', 
                size: 16, 
            },
                
            }
        }
    } 
}

};
new Chart(ProductionStatus, config1);



const certificationsAchieveds = document.getElementById('graphicCertificationsAchieveds');

new Chart(certificationsAchieveds, {
type: 'bar',

data: {
  labels: ['Não Possui', 'Sim/POA', 'SUSAF', 'SISBI', 'SELO ARTE', 'SIF'],
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

const technologies = document.getElementById('technologies');

new Chart(technologies, {
    type: 'bar',
    data: {
        labels: ['Canastra', 'Minas', 'Brie', 'Cheddar', 'Gouda', 'Mussarela'],
        datasets: [{
            label: 'Produzindo',
            backgroundColor: 'rgb(5, 155, 255, 0.6)',
            borderColor: 'rgb(5, 155, 255, 10)',
            borderWidth: 4,
            data: [55, 77, 30, 25, 25, 3]
        }, {
            label: 'Em complementação',
            backgroundColor: 'rgb(255, 194, 52, 0.6)',
            borderColor: 'rgb(255, 194, 52)',
            borderWidth: 4,
            data: [35, 50, 20, 15, 30, 5]
        }, {
            label: 'Desistentes',
            backgroundColor: 'rgb(255, 64, 105, 0.6)',
            borderColor: 'rgb(255, 64, 105, 10)',
            borderWidth: 4,
            data: [20, 30, 10, 10, 20, 2]
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
