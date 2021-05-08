const BundleAnalyzerPlugin = require('webpack-bundle-analyzer').BundleAnalyzerPlugin;

module.exports = {
	devServer: {
		port: 3000,
		proxy: 'http://localhost:8080'
	},
	configureWebpack: {
		plugins: [new BundleAnalyzerPlugin(
			{
				analyzerMode: 'disabled'
			}
		)],
		resolve: {
			alias: {
				moment: 'moment/src/moment'
			}
		}
	}
}