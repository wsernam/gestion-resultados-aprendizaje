import { HttpInterceptorFn } from '@angular/common/http';

export const authInterceptor: HttpInterceptorFn = (req, next) => {
  const excludedUrls = [
    '/api/login',]
  if (excludedUrls.some(url => req.url.includes(url))) {
    return next(req);
  }

  const token = (typeof window !== 'undefined' && window.sessionStorage) ? window.sessionStorage.getItem('token'): null;

  if (token) {
    const authReq = req.clone({
      setHeaders: {
        Authorization: `Bearer ${token}`
      }
    });
    return next(authReq);
  }
  return next(req);
};
