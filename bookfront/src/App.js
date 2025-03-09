// App.js
import React from 'react';
import { Routes, Route } from 'react-router-dom'; // Router 관련 컴포넌트만 임포트
import Login from './Login';
import SignUp from './SignUp';

const App = () => {
  return (
    <Routes>  {/* Routes로 라우팅 설정 */}
      <Route path="/login" element={<Login />} />
      <Route path="/signup" element={<SignUp />} />
      <Route path="/" element={<Login />} />
    </Routes>
  );
};

export default App;
