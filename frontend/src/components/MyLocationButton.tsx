import { CSSProperties } from 'react';

interface MyLocationButtonProps {
    onClick: () => void;
}

export default function MyLocationButton({ onClick }: MyLocationButtonProps) {
    const buttonStyle: CSSProperties = {
        position: 'absolute',
        bottom: '90px',
        right: '20px',
        width: '50px',
        height: '50px',
        backgroundColor: 'white',
        borderRadius: '50%',
        border: 'none',
        boxShadow: '0 2px 8px rgba(0, 0, 0, 0.15)',
        cursor: 'pointer',
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center',
        zIndex: 200,
        transition: 'all 0.2s ease',
    };

    const iconStyle: CSSProperties = {
        width: '24px',
        height: '24px',
        color: '#1e88e5',
    };

    return (
        <button 
            style={buttonStyle}
            onClick={onClick}
            onMouseEnter={(e) => {
                e.currentTarget.style.transform = 'scale(1.1)';
                e.currentTarget.style.boxShadow = '0 4px 12px rgba(0, 0, 0, 0.2)';
            }}
            onMouseLeave={(e) => {
                e.currentTarget.style.transform = 'scale(1)';
                e.currentTarget.style.boxShadow = '0 2px 8px rgba(0, 0, 0, 0.15)';
            }}
        >
            <svg style={iconStyle} viewBox="0 0 24 24" fill="none" stroke="currentColor">
                <circle cx="12" cy="12" r="10" strokeWidth="2" />
                <circle cx="12" cy="12" r="3" strokeWidth="2" />
                <line x1="12" y1="2" x2="12" y2="6" strokeWidth="2" strokeLinecap="round" />
                <line x1="12" y1="18" x2="12" y2="22" strokeWidth="2" strokeLinecap="round" />
                <line x1="2" y1="12" x2="6" y2="12" strokeWidth="2" strokeLinecap="round" />
                <line x1="18" y1="12" x2="22" y2="12" strokeWidth="2" strokeLinecap="round" />
            </svg>
        </button>
    );
}