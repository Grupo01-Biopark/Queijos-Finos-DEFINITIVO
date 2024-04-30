const ProductionStatus = document.getElementById('graphicProductionStatus');

const config1 = {

  type: 'doughnut',

  data: {

    labels: ['Ativos Produzindo', 'Ativos em complementação', 'Desistentes', 'Desligados'],

    datasets: [{

      label: '',

      data: [83, 47, 25, 10],

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
                style: 'normal'
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

    label: 'false', //remover aparencia da lable

    data: [55, 77, 30, 25, 25, 3],

    borderWidth: 1
    
    }]},

    options: {

    scales: {

      y: {
        grid: {
            display: false // Remove as linhas de grade do eixo Y
        },
        beginAtZero: true
    },
    x: {
        grid: {
            display: false // Remove as linhas de grade do eixo X
        }
    },
    
        beginAtZero: true
        }
    }
    }
    );                      