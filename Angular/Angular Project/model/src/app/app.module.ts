import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FlatNodeTreeComponent } from './flat-node-tree/flat-node-tree.component';
import {MatTreeModule} from '@angular/material/tree';
import { MatIconModule } from "@angular/material/icon";
import { NestedTreeExampleComponent } from './nested-tree-example/nested-tree-example.component';
import { FinalTreeComponent } from './final-tree/final-tree.component';
import { TreeNestedOverviewExampleComponent } from './tree-nested-overview-example/tree-nested-overview-example.component';
import { FlatedDynamicTreeComponent } from './flated-dynamic-tree/flated-dynamic-tree.component';

@NgModule({
    declarations: [
        AppComponent,
        FlatNodeTreeComponent,
        NestedTreeExampleComponent,
        FinalTreeComponent,
        TreeNestedOverviewExampleComponent,
        FlatedDynamicTreeComponent
    ],
    providers: [],
    bootstrap: [AppComponent],
    imports: [
        BrowserModule,
        AppRoutingModule,
        BrowserAnimationsModule,
        MatTreeModule,
        MatIconModule
    ]
})
export class AppModule { }
