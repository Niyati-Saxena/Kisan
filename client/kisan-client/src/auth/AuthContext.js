import { createContext, useContext, useState } from 'react';

const AuthContext = createContext(null);

export function AuthProvider({ children }) {
  const [user, setUser] = useState(() => {
    const token = localStorage.getItem('token');
    const userId = localStorage.getItem('userId');
    const name = localStorage.getItem('name');
    const role = localStorage.getItem('role');

    if (!token) {
      return null;
    }

    return {
      token,
      userId,
      name,
      role
    };
  });

  const login = (loginResponse) => {
    const loggedInUser = {
      token: loginResponse.token,
      userId: loginResponse.userId,
      name: loginResponse.name,
      role: loginResponse.role
    };

    localStorage.setItem('token', loginResponse.token);
    localStorage.setItem('userId', loginResponse.userId);
    localStorage.setItem('name', loginResponse.name);
    localStorage.setItem('role', loginResponse.role);

    setUser(loggedInUser);
  };

  const logout = () => {
    localStorage.removeItem('token');
    localStorage.removeItem('userId');
    localStorage.removeItem('name');
    localStorage.removeItem('role');

    setUser(null);
  };

  const isAuthenticated = user !== null;

  return (
    <AuthContext.Provider
      value={{
        user,
        login,
        logout,
        isAuthenticated
      }}
    >
      {children}
    </AuthContext.Provider>
  );
}

export function useAuth() {
  return useContext(AuthContext);
}