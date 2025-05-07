import { Component, OnInit } from "@angular/core"; 
import { NestedTreeControl } from "@angular/cdk/tree"; 
import { MatTreeNestedDataSource } from "@angular/material/tree";

interface Bpno{
  name : string;
	bpno?: Bpno[];
}

interface Pafjson{
	name : string;
	paf?: Pafjson[];
	bpno?: Bpno[];
}

interface Cpsc2json{
	name : string;
	cpsc2?: Cpsc2json[];
	paf?: Pafjson[];
	bpno?: Bpno[];
}

interface Pmtjson{
	name : string;
	pmt? : Pmtjson[];
	cpsc2? : Cpsc2json[];
	paf?: Pafjson[];
	bpno?: Bpno[];
}

interface Css{
	name : string;
	pmt?: Pmtjson[];
	cpsc2?: Cpsc2json[];
	paf?: Pafjson[];
	bpno?: Bpno[];
}

const TREE_DATA: Css[] =[
  {
    name : '1111',
    pmt : [
      {
        name : '400 Powertrain_IE',
        pmt : [
          {
            name : '410 Installation test',
            pmt : [
              {
                name : '411 Cooling',
                cpsc2 : [
                  {
                    name : '000403 test',
                    paf : [
                      {
                        name : '2OA75 - 000411',
                      },
                    ],
                  },
                ],
              },
            ],
            cpsc2 : [
              {
                name : '131310 TEST IE 11',
                paf : [
                  {
                    name : 'UKQ86 - ie',
                    paf : [
                      {
                        name : 'O35B9 - test',
                      },
                    ],
                    bpno : [
                      {
                        name : '13702, SEQ3 000, TRMNL-I/PNL LP SCKT',
                      },
                      {
                        name : '13702, SEQ3 000, TRMNL-I/PNL LP 2134'
                      }
                    ],
                  },
                ],
              },
            ],
          },
        ],
      },
    ],
  },
  {
    name : '1212',
    pmt : [
      {
        name : '700 Vechicle Personalization',
        pmt : [
          {
            name : '710 New Accessories',
            cpsc2 : [
              {
                name : '030340 Test4',
                paf : [
                  {
                    name : 'Z5KPA - UKQ86',
                  },
                ],
              },
            ],
          },
        ],
      },
    ],
  },
];

@Component({
  selector: 'app-final-tree',
  templateUrl: './final-tree.component.html',
  styleUrls: ['./final-tree.component.css']
})
export class FinalTreeComponent {

  cssTreeControl = new NestedTreeControl<Css>((node) => {

    if(node.pmt) return node.pmt;
    if(node.cpsc2) return node.cpsc2;
    if(node.paf) return node.paf;
    if(node.bpno) return node.bpno;
    return;

    // return (node.pmt) ? node.pmt : 
    // ((node.cpsc2)? node.cpsc2 : 
    // ((node.paf)? node.paf : node.bpno))
  });
  dataSource = new MatTreeNestedDataSource<Css>();

  constructor() { 
    this.dataSource.data = TREE_DATA; 
  }

hasChildInPmt (_: string, node : Pmtjson) : boolean {

  return (node.pmt) ?
  !!node.pmt && node.pmt.length > 0 :
  ((node.cpsc2) ? !!node.cpsc2 && node.cpsc2.length > 0 :
  ((node.paf) ? !!node.paf && node.paf.length > 0 : 
  !!node.bpno && node.bpno.length > 0))
}

  ngOnInit(): void {}

}
