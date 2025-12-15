import { CSSProperties } from 'react';

export default function BottomNav() {
    const navStyle: CSSProperties = {
        position: 'absolute',
        bottom: 0,
        left: 0,
        right: 0,
        height: '70px',
        backgroundColor: 'white',
        borderTop: '1px solid #e0e0e0',
        display: 'flex',
        justifyContent: 'space-around',
        alignItems: 'center',
        zIndex: 100,
    };

    const navItemStyle: CSSProperties = {
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
        gap: '4px',
        cursor: 'pointer',
        padding: '8px',
    };

    const iconStyle: CSSProperties = {
        width: '24px',
        height: '24px',
        color: '#666',
    };

    const labelStyle: CSSProperties = {
        fontSize: '11px',
        color: '#666',
    };

    return (
        <nav style={navStyle}>
            <div style={navItemStyle}>
                <svg style={iconStyle} viewBox="0 0 24 24" fill="none" stroke="currentColor">
                    <rect x="3" y="3" width="18" height="18" rx="2" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round" />
                    <path d="M3 9h18" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round" />
                    <path d="M9 21V9" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round" />
                </svg>
                <span style={labelStyle}>지도보기</span>
            </div>
            
            <div style={navItemStyle}>
                <svg style={iconStyle} viewBox="0 0 24 24" fill="none" stroke="currentColor">
                    <path d="M20.84 4.61a5.5 5.5 0 0 0-7.78 0L12 5.67l-1.06-1.06a5.5 5.5 0 0 0-7.78 7.78l1.06 1.06L12 21.23l7.78-7.78 1.06-1.06a5.5 5.5 0 0 0 0-7.78z" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round" />
                </svg>
                <span style={labelStyle}>즐겨찾기</span>
            </div>
            
            <div style={navItemStyle}>
                <svg style={iconStyle} viewBox="0 0 24 24" fill="none" stroke="currentColor">
                    <path d="M20 21v-2a4 4 0 0 0-4-4H8a4 4 0 0 0-4 4v2" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round" />
                    <circle cx="12" cy="7" r="4" strokeWidth="2" />
                </svg>
                <span style={labelStyle}>내 정보</span>
            </div>
        </nav>
    );
}