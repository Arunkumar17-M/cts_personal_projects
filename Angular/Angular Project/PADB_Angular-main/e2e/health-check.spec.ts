import {
	expect,
	Locator,
	test
} from '@playwright/test';


test.beforeEach(async ({page}) => {
	await page.goto('/health');
});

test('Health Check', async ({page}) => {
	await expect(page.locator('body')).toContainText('{"status":"UP"}');
});
