import { Component } from '@angular/core';
import { FlatTreeControl } from '@angular/cdk/tree';
import { MatTreeFlatDataSource, MatTreeFlattener } from '@angular/material/tree';

interface Css {
  name: string;
  pmt?: Css[];
  cpsc2?: Css[];
  paf?: Css[];
  bpno?: Css[];
}

interface ExampleFlatNode {
  expandable: boolean;
  name: string;
  level: number;
}

const TREE_DATA = [
  {
    name: '1111',
    pmt: [
      {
        name: '400 Powertrain_IE',
        pmt: [
          {
            name: '410 Installation test',
            pmt: [
              {
                name: '411 Cooling',
                cpsc2: [
                  {
                    name: '000403 test',
                    paf: [
                      {
                        name: '2OA75 - 000411',
                      },
                    ],
                  },
                ],
              },
            ],
            cpsc2: [
              {
                name: '131310 TEST IE 11',
                paf: [
                  {
                    name: 'UKQ86 - ie',
                    paf: [
                      {
                        name: 'O35B9 - test',
                      },
                    ],
                    bpno: [
                      {
                        name: '13702, SEQ3 000, TRMNL-I/PNL LP SCKT',
                      },
                      {
                        name: '13702, SEQ3 000, TRMNL-I/PNL LP 1234',
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
    name: '1212',
    pmt: [
      {
        name: '700 Vechicle Personalization',
        pmt: [
          {
            name: '710 New Accessories',
            cpsc2: [
              {
                name: '030340 Test4',
                paf: [
                  {
                    name: 'Z5KPA - UKQ86',
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
  selector: 'app-flated-dynamic-tree',
  templateUrl: './flated-dynamic-tree.component.html',
  styleUrls: ['./flated-dynamic-tree.component.css']
})
export class FlatedDynamicTreeComponent {

  private _transformer = (node: Css, level: number) => {
    return {
      expandable: (!!node.pmt && node.pmt.length > 0) || (!!node.cpsc2 && node.cpsc2.length > 0) || (!!node.paf && node.paf.length > 0) || (!!node.bpno && node.bpno.length > 0),
      name: node.name,
      level: level,
    };
  }

  treeControl = new FlatTreeControl<ExampleFlatNode>(
    node => node.level, node => node.expandable);

  treeFlattener = new MatTreeFlattener(
    this._transformer, node => node.level, node => node.expandable, node => [...(node.pmt || []), ...(node.cpsc2 || []), ...(node.paf || []), ...(node.bpno || [])]);

  dataSource = new MatTreeFlatDataSource(this.treeControl, this.treeFlattener);

  constructor() {
    this.dataSource.data = TREE_DATA;
  }

  hasChild = (_: number, node: ExampleFlatNode) => node.expandable;
}
