/**
 * spring data page
 */
export class Page<T> {
  content: T[];
  last: boolean;
  totalElements: number;
  totalPages: number;
  number: number;
  size: number;
  sort: any;
  first: boolean;
  numberOfElements: number;
}
