<script>
    import { Line } from 'vue-chartjs';

    export default {
        name: 'FinanceChart',
        data() {
            return {
                dataSet: {
                    label: 'currency',
                    data: [],
                    backgroundColor: '#7ac0c088',
                    borderColor: '#3f8c4a',
                    fill: 'start'
                },
                options: {
                    maintainAspectRatio: true,
                    responsive: true,
                    aspectRatio: this.aspectRatio,
                    tooltips: {
                        intersect: false,
                        mode: 'index'
                    }
                }
            }
        },
        props: {
            label: 'currency',
            aspectRatio: {
                default: 2
            },
            chartData: {
                type: Array,
                default: null
            }
        },
        mounted() {
            var dataLabels = [];
            var lastMaxValue = -1000000;
            var lastMinValue = 1000000;
            var lastLabel = '';
            //TODO: change naming to more common
            if (this.chartdata && this.chartdata.length > 0){
                lastMaxValue = this.chartdata[0].maximumTemperature.toFixed(2);
                lastMinValue = this.chartdata[0].minimalTemperature.toFixed(2);
                lastLabel = this.chartdata[0].time[2];
            }

            if (this.chartdata) {
                for (var i = 0; i < this.chartdata.length; i++) {
                    if (this.chartdata[i].time[2] !== lastLabel || i + 1 == this.chartdata.length) {
                        dataLabels.push(lastLabel);
                        this.dataSetOne.data.push(lastMinTemp);
                        this.dataSetTwo.data.push(lastMaxTemp);
                        lastMaxTemp = -250;
                        lastMinTemp = 250;
                    }
                    if (this.chartdata[i].maximumTemperature > lastMaxTemp) {
                        lastMaxTemp = this.chartdata[i].maximumTemperature.toFixed(2);
                    }
                    if (this.chartdata[i].minimalTemperature < lastMinTemp) {
                        lastMinTemp = this.chartdata[i].minimalTemperature.toFixed(2);
                    }
                    lastLabel = this.chartdata[i].time[2];
                }
            }

            var chartdataone = {
                labels: dataLabels,
                datasets: [
                    this.dataSetOne,
                    this.dataSetTwo
                ]
            };

            this.renderChart(chartdataone, this.options);
        }
    }
</script>

<style>

</style>
