export interface Gender {
  value: number,
  text: string;
}

/**
 * static gender data,mapper to server side model
 */
export const Genders: Gender[] = [
  {value: 1, text: 'male'},
  {value: 2, text: 'female'}
];
