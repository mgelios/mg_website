<script>
    import { Line } from 'vue-chartjs';

    export default {
        name: 'TemperatureForecastChart',
        extends: Line,
        data() {
            return {
                chartData: {
                    labels: this.temperatureLabels,
                    datasets: [{
                        label: 'min temp',
                        data: this.minTempData,
                        backgroundColor: 'rgba(122,129,192,0.64)',
                        borderColor: '#7aa2c0',
                        fill: 'start'
                    },
                    {
                        label: 'max temp',
                        data: this.maxTempData,
                        backgroundColor: '#e6896688',
                        borderColor: '#e68966',
                        fill: '0'
                    }]
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
            height: null,
            width: {
                default: "100%"
            },
            aspectRatio: {
                default: 4
            },
            temperatureLabels: {
                default: function() {
                    return [];
                }
            },
            maxTempData: {
                default: function() {
                    return [];
                }
            },
            minTempData: {
                default: function() {
                    return [];
                }
            }
        },
        mounted() {
            this.renderChart(this.chartData, this.options);
        },
    }
</script>