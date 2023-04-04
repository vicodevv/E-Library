import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { CustomerModule } from './app/customers/customer.module';


platformBrowserDynamic().bootstrapModule(CustomerModule)
  .catch(err => console.error(err));
