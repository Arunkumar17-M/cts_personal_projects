import {Component} from '@angular/core';
import {MenuItem} from 'primeng/api';

/** Angular component that utilizes the PrimeNG p-menubar component
 * to display the navigation menu for the application
 */
@Component({
	selector: 'app-nav',
	templateUrl: './nav.component.html',
	styleUrls: ['./nav.component.scss']
})
export class NavComponent {
	/** Array of PrimeNG MenuItems that are used to populate the p-menubar */
	navMenuItems: MenuItem[];

	/** Create a nav component and populate with necessary MenuItems (static data) */
	constructor() {
		this.navMenuItems = [
			{
				label: 'Example Page',
				routerLink: '/example-page'
			},
			{
				label: 'Example Dropdown',
				items: [
					{
						label: 'Nested1',
						items: [
							{
								label: 'Option1',
								icon: 'fas fa-check'
							}
						]
					},
					{
						label: 'Nested2',
						items: [
							{
								label: 'Option2',
								icon: 'fas fa-plus'
							}
						]
					}
				]
			}
		];
	}
}
