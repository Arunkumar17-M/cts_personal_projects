import {NestedTreeControl} from '@angular/cdk/tree';
import {Component, Injectable} from '@angular/core';
import {MatTreeNestedDataSource} from '@angular/material/tree';
import {BehaviorSubject} from 'rxjs';

/**
 * Json node data with nested structure. Each node has a filename and a value or a list of children
 */
export class FileNode {
  children: FileNode[] =[];
  filename: string = '';
  type: any;
}

/**
 * The Json tree data in string. The data could be parsed into Json object
 */
// const TREE_DATA = JSON.stringify({
//   Applications: {
//     Calendar: 'app',
//     Chrome: 'app',
//     Webstorm: 'app'
//   },
//   Documents: {
//     angular: {
//       src: {
//         compiler: 'ts',
//         core: 'ts'
//       }
//     },
//     material2: {
//       src: {
//         button: 'ts',
//         checkbox: 'ts',
//         input: 'ts'
//       }
//     }
//   },
//   Downloads: {
//     October: 'pdf',
//     November: 'pdf',
//     Tutorial: 'html'
//   },
//   Pictures: {
//     'Photo Booth Library': {
//       Contents: 'dir',
//       Pictures: 'dir'
//     },
//     Sun: 'png',
//     Woods: 'jpg'
//   }
// });

const TREE_DATA = JSON.stringify({
  '1111' : {
    '400 Powertrain_IE' : {
      '410 Installation test' : {
        '411 Cooling' : {
          '000403 test' : {
            'BPNO': '2OA75 - 000411'
          }
        },
        '131310 TEST IE 11' : {
          'UKQ86 - ie': {
            'PAF' : 'O35B9 - test',
            'BPNO': '13702, SEQ3 000, TRMNL-I/PNL LP SCKT'
          }
        }
      }
    }
  },
  '1212':{
    '700 Vechicle Personalization' : {
      '710 New Accessories' : {
        '030340 Test4' : {
          'PAF': 'Z5KPA - UKQ86'
        }
      }
    }
  }
});

/**
 * File database, it can build a tree structured Json object from string.
 * Each node in Json object represents a file or a directory. For a file, it has filename and type.
 * For a directory, it has filename and children (a list of files or directories).
 * The input will be a json object string, and the output is a list of `FileNode` with nested
 * structure.
 */
@Injectable()
export class FileDatabase {
  dataChange = new BehaviorSubject<FileNode[]>([]);

  get data(): FileNode[] { return this.dataChange.value; }

  constructor() {
    this.initialize();
  }

  initialize() {
    // Parse the string to json object.
    const dataObject = JSON.parse(TREE_DATA);

    // Build the tree nodes from Json object. The result is a list of `FileNode` with nested
    //     file node as children.
    const data = this.buildFileTree(dataObject, 0);

    // Notify the change.
    this.dataChange.next(data);
  }

  /**
   * Build the file structure tree. The `value` is the Json object, or a sub-tree of a Json object.
   * The return value is the list of `FileNode`.
   */
  buildFileTree(obj: {[key: string]: any}, level: number): FileNode[] {
    return Object.keys(obj).reduce<FileNode[]>((accumulator, key) => {
      const value = obj[key];
      const node = new FileNode();
      node.filename = key;

      if (value != null) {
        if (typeof value === 'object') {
          node.children = this.buildFileTree(value, level + 1);
        } else {
          node.type = value;
        }
      }

      return accumulator.concat(node);
    }, []);
  }
}

/**
 * @title Tree with nested nodes
 */
@Component({
  selector: 'app-tree-nested-overview-example-comonent',
  templateUrl: 'tree-nested-overview-example.component.html',
  styleUrls: ['tree-nested-overview-example.component.css'],
  providers: [FileDatabase]
})
export class TreeNestedOverviewExampleComponent {
  nestedTreeControl: NestedTreeControl<FileNode>;
  nestedDataSource: MatTreeNestedDataSource<FileNode>;

  constructor(database: FileDatabase) {
    this.nestedTreeControl = new NestedTreeControl<FileNode>(this._getChildren);
    this.nestedDataSource = new MatTreeNestedDataSource();

    database.dataChange.subscribe(data => this.nestedDataSource.data = data);
  }

  hasNestedChild = (_: number, nodeData: FileNode) => !nodeData.type;

  private _getChildren = (node: FileNode) => node.children;
}
