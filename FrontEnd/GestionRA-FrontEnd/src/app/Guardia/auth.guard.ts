import { CanActivateFn } from '@angular/router';
import { inject } from '@angular/core';
import { Router } from '@angular/router';

export const authGuard: CanActivateFn = (route, state) => {
  const router = inject(Router);
  const token = (typeof window !== 'undefined' && window.sessionStorage) ? window.sessionStorage.getItem('token') || "" : "";

  if (token !== ""){
    return true;
  } else {
    router.navigate(['']);
    return false;
  }
};
