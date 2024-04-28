const ProductionStatus = document.getElementById('graphicProductionStatus');
const config1 = {
  type: 'doughnut',
  data: {
    labels: ['Ativos Produzindo', 'Ativos em complementação', 'Desistentes','Desligados'],

    datasets: [{
      label: '',
      data: [300, 50, 30,70],
      backgroundColor: 
      ['rgb(255, 99, 132)',
      'rgb(54, 162, 235)',
      'rgb(255, 205, 86)',
      'rgb(255, 205, 86)',
      'rgb(38, 35, 30)'],

      hoverOffset: 5
      
    }]
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
    label: '',
    data: [55, 77, 30, 25, 25, 3],
    borderWidth: 1
    }]
    },
    options: {

    scales: {

        y: {
            
        beginAtZero: true
        }
    }
    }
    });                      