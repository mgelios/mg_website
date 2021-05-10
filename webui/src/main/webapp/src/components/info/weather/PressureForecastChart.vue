<script>
    import { Line } from 'vue-chartjs';

    export default {
        name: 'PressureForecastChart',
        extends: Line,
        data() {
            return {
                chartData: {
                    labels: ['some1', 'some2', 'some3'],
                    datasets: [{
                        label: 'someLabel',
                        data: [1,2,3],
                        backgroundColor: '#7ac0c088',
                        borderColor: '#7ac0c0',
                        fill: 'start'
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
            }
        },
        mounted() {
            this.renderChart(this.chartData, this.options);
        }
    }
</script>