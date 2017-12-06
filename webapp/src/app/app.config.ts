import {InjectionToken} from '@angular/core';

export interface IAppConfig {
  appName: string;
  apiEndPoint: string;
}

export const AppConfig: IAppConfig = {
  appName: 'School App Demo',
  apiEndPoint: 'http://localhost:8080'
};

export const APP_CONFIG = new InjectionToken<IAppConfig>('app.config');
