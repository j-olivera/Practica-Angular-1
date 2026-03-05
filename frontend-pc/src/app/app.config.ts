import { ApplicationConfig, provideBrowserGlobalErrorListeners, provideZoneChangeDetection,
  provideZonelessChangeDetection
} from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { provideHttpClient } from '@angular/common/http';

export const appConfig: ApplicationConfig = {
  providers: [
    provideBrowserGlobalErrorListeners(),
    provideRouter(routes),
    provideHttpClient(),
    provideZonelessChangeDetection() // se actualiza "manualmente" con un metodo en el complemento, en este caso lista-pc con un ChangeDetectorRef
  ]   //por alguna razon no actualizaba, pero esto debería hacerlo angular automaticamente
};
