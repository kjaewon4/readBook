import React, { useState } from "react";
import { Link } from "react-router-dom";  
import { FiEye, FiEyeOff } from "react-icons/fi";
import "./main.css";

const Login = () => {
    const [userName, setUserName] = useState("");
    const [userPassword, setUserPassword] = useState("");
    const [showPassword, setShowPassword] = useState(false);  // 비밀번호 표시 여부
  
    const handleSubmit = (e) => {
      e.preventDefault();
      console.log("아이디:", userName);
      console.log("비밀번호:", userPassword);
    };
  
    const togglePasswordVisibility = () => {
      setShowPassword(!showPassword);  // 비밀번호 표시 상태를 반전
    };
  
    return (
      <div className="login-container">
        <h2>로그인</h2>
        <form onSubmit={handleSubmit} className="login-form">
          <div className="input-group">
            <label htmlFor="userName">아이디</label>
            <input
              type="text"
              id="userName"
              value={userName}
              onChange={(e) => setUserName(e.target.value)}
              required
            />
          </div>
          <div className="input-group">
            <label htmlFor="userPassword">비밀번호</label>
            <div className="password-wrapper">
              <input
                type={showPassword ? "text" : "password"} // 비밀번호 표시/숨김 토글
                id="userPassword"
                value={userPassword}
                onChange={(e) => setUserPassword(e.target.value)}
                required
              />
              <span className="password-eye-icon" onClick={togglePasswordVisibility}>
                {showPassword ? <FiEyeOff /> : <FiEye />} {/* 눈 아이콘을 클릭하면 표시/숨김 전환 */}
              </span>
            </div>
          </div>
          <button type="submit" className="login-btn">
            로그인
          </button>
        </form>
        <div className="signup-link">
          <p>아직 회원이 아니신가요? <Link to="/signup">회원가입</Link></p>
        </div>
      </div>
    );
};

export default Login;
