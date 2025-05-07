import { Component, OnInit } from "@angular/core"; 
import { NestedTreeControl } from "@angular/cdk/tree"; 
import { MatTreeNestedDataSource } from "@angular/material/tree"; 

interface Smartphone { 
parent_company: string; 
sub_brand?: Smartphone[];
} 

const TREE_DATA: Smartphone[] = [ 
{ 
	parent_company: "Xiaomi", 
	sub_brand: [ 
	{ parent_company: "Poco" }, 
	{ parent_company: "Redmi" }, 
	{ parent_company: "Mijia" }, 
	], 
}, 
{ 
	parent_company: "BBK Electronics", 
	sub_brand: [ 
	{ 
		parent_company: "Vivo", 
		sub_brand: [{ parent_company: "iQoo" }], 
	}, 
	{ 
		parent_company: "Oppo", 
		sub_brand: [{ parent_company: "Realme" }, 
					{ parent_company: "Dizo" }], 
	},
  {
    parent_company : "Samsung"
  }
	],
}, 
]; 

@Component({ 
selector: "app-nested-tree-example", 
templateUrl: "./nested-tree-example.component.html", 
styleUrls: ["./nested-tree-example.component.css"], 
}) 
export class NestedTreeExampleComponent implements OnInit { 
treeControl = new NestedTreeControl<Smartphone>((node) => node.sub_brand); 
dataSource = new MatTreeNestedDataSource<Smartphone>(); 
constructor() { 
	this.dataSource.data = TREE_DATA; 
} 
hasChild = (_: number, node: Smartphone) => 
	!!node.sub_brand && node.sub_brand.length > 0; 

ngOnInit(): void {} 
}
