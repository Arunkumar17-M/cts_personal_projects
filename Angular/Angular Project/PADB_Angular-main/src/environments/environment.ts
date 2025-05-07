/**This file contains a constant object that has properties that are necessary
 * for the build found in the `local` configuration in `angular.json`.
 * The contents of this file will be overwritten for other configurations.
 */

export const environment = {
	production: false,
	baseUrl: 'https://localhost:8080/api/',
	openidUrl: 'https://corpqa.sts.ford.com/adfs/oauth2/authorize/wia',
	openidClientId: '',
	openidResource: ''
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
import 'zone.js/plugins/zone-error';  // Included with Angular CLI.
