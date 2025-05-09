import {
	devices,
	PlaywrightTestConfig
} from '@playwright/test';

/**
 * See https://playwright.dev/docs/test-configuration.
 */
process.env.PLAYWRIGHT_BROWSERS_PATH = "0";
const config: PlaywrightTestConfig = {
	/* Running local in-mem server to use Playwright for local integration tests */
	webServer: {
		command: 'npm run start-local',
		port: 9500,
		timeout: 120 * 1000,
		reuseExistingServer: !process.env.CI
	},

	testDir: './e2e',

	/* Ignore this health-check test in local configs as it is meant for deployed environment only */
	testIgnore: 'health-check.spec.ts',

	/* Maximum time one test can run for. */
	timeout: 30 * 1000,

	expect: {

		/**
		 * Maximum time expect() should wait for the condition to be met.
		 * For example in `await expect(locator).toHaveText();`
		 */
		timeout: 5000
	},

	/* Fail the build on CI if you accidentally left test.only in the source code. */
	forbidOnly: !!process.env.CI,

	/* Retry on CI only */
	retries: process.env.CI ? 2 : 0,

	/* Opt out of parallel tests on CI. */
	workers: process.env.CI ? 1 : undefined,

	/* Reporter to use. See https://playwright.dev/docs/test-reporters */
	reporter: 'list',

	/* Shared settings for all the projects below. See https://playwright.dev/docs/api/class-testoptions. */
	use: {

		/* Maximum time each action such as `click()` can take. Defaults to 0 (no limit). */
		actionTimeout: 0,

		/* Base URL to use in actions like `await page.goto('/')`. */
		baseURL: 'http://localhost:9500/',

		/* Collect trace when retrying the failed test. See https://playwright.dev/docs/trace-viewer */
		trace: 'on-first-retry'
	},

	/* Configure projects for major browsers */
	projects: [
		{
			name: 'chromium',

			/* Project-specific settings. */
			use: {
				...devices['Desktop Chrome']
			}
		}

		// {
		// 	name: 'firefox',
		// 	use: {
		// 		...devices['Desktop Firefox']
		// 	}
		// },
		//
		// {
		// 	name: 'webkit',
		// 	use: {
		// 		...devices['Desktop Safari']
		// 	}
		// }

		/* Test against mobile viewports. */
		//{
		//	name: 'Mobile Chrome',
		//	use: {
		//		...devices['Pixel 5']
		//	}
		//}
		// },
		// {
		//   name: 'Mobile Safari',
		//   use: {
		//     ...devices['iPhone 12'],
		//   },
		// },

		/* Test against branded browsers. */
		// {
		//   name: 'Microsoft Edge',
		//   use: {
		//     channel: 'msedge',
		//   },
		// },
		// {
		//   name: 'Google Chrome',
		//   use: {
		//     channel: 'chrome',
		//   },
		// },
	]

	/* Folder for test artifacts such as screenshots, videos, traces, etc. */
	// outputDir: 'test-results/',

};
export default config;
